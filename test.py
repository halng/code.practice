import json
import subprocess
import logging
import time

logging.basicConfig(format="%(asctime)s - %(message)s", level=logging.INFO)
logging.info("Admin logged in")

LANGUAGE = "supported_languages"
JAVA = "java"
PYTHON = "python"
CPP = "cpp"
GO = "go"
RUST = "rust"
JAVASCRIPT = "javascript"

ID = "id"
TEST_CASE = "test-cases"
NAME = "name"
DESCRIPTION = "description"
INPUT = "input"
OUTPUT = "output"

RESULT_MAPPING = {True: "PASSED", False: "FAILED"}
DEFAULT_FILE_NAME = "main"
EXTENSION_MAPPING = {
    JAVA: ".java",
    PYTHON: ".py",
    CPP: ".cpp",
    GO: ".go",
    RUST: ".rs",
    JAVASCRIPT: ".js",
}


def execute(cli):
    result = subprocess.run(cli, capture_output=True, text=True).stdout
    return result


def test_java(input, path: str):
    start_time = time.time()
    cli = ["java", path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_python(input, path: str):
    start_time = time.time()
    cli = ["python3", path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_cpp(input, path: str):
    start_time = time.time()
    output_path = path.replace(".cpp", "")
    cli = ["g++", path, "-o", output_path]
    _ = execute(cli)
    cli = [output_path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    # remove output file
    _ = execute(["rm", output_path])
    return result, execution_time


def test_go(input, path: str):
    start_time = time.time()
    cli = ["go", "run", path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_rust(input, path: str):
    start_time = time.time()
    output_path = path.replace(".rs", "")
    cli = ["rustc", path, "-o", output_path ]
    _ = execute(cli)
    cli = [output_path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    cli = ["rm", output_path]
    _ = execute(cli)
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_javascript(input, path: str):
    start_time = time.time()
    cli = ["node", path] + input.split(" ")
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


if __name__ == "__main__":
    logging.info("Starting test")
    with open("./cases.json", "r") as f:
        test_data = json.load(f)

    function_mapping = {
        JAVA: test_java,
        PYTHON: test_python,
        CPP: test_cpp,
        GO: test_go,
        RUST: test_rust,
        JAVASCRIPT: test_javascript,
    }

    for test in test_data:
        test_cases = test[TEST_CASE]
        output = {
           
        }

        logging.info("=" * 50)
        logging.info(f"== ID {test[ID]}")
        logging.info(f"== NAME: {test[NAME]}")
        logging.info(f"== DESCRIPTION: {test[DESCRIPTION]}")
        logging.info(f"== TOTAL: {len(test_cases)} test case(s)")

        for language in test[LANGUAGE]:
            logging.info(f"========== START TEST FOR LANGUAGE: {language} ==========")
            output[language] = {
                "PASSED": 0,
                "FAILED": 0
            }
            
            func = function_mapping[language]
            for i, case in enumerate(test_cases):
                test_input = " ".join(map(str, case[INPUT]))
                test_output = "".join(map(str, case[OUTPUT]))
                path = f"{test[ID]}/{DEFAULT_FILE_NAME}{EXTENSION_MAPPING[language]}"
                result, execution_time = func(test_input, path)

                final_result = result.strip() == test_output

                logging.info(
                    f"== TEST CASE: {i+1}: {case[NAME]}: {RESULT_MAPPING[final_result]} takes {execution_time} seconds"
                )
                if not final_result:
                    logging.info(f"== EXPECTED: {test_output}")
                    logging.info(f"== GOT: {result}")
                    output[language]["FAILED"] +=  1
                else:
                    output[language]["PASSED"] += 1

        logging.info(f"== SUMMARY: {output}")