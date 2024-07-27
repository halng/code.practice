import json
import subprocess
import logging
import time
import os

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
EXTENSION_MAPPING = {JAVA: ".java", PYTHON: ".py", CPP: ".cpp", GO: ".go", RUST: ".rs"}

LOGGING_MESSAGE_1 = "PROBLEM: {} | TEST_CASE: {}"
LOGGING_MESSAGE_2 = "\tLANGUAGE: {} | TOOK: {} | RESULT: {}"


def execute(cli):
    result = subprocess.run(cli, capture_output=True, text=True).stdout
    return result


def test_java(path: str):
    start_time = time.time()
    cli = ["java", path]
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_python(path: str):
    start_time = time.time()
    cli = ["python3", path]
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_cpp(path: str):
    start_time = time.time()
    output_path = path.replace(".cpp", "")
    cli = ["g++", path, "-o", output_path]
    _ = execute(cli)
    cli = [output_path]
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    # remove output file
    _ = execute(["rm", output_path])
    return result, execution_time


def test_go(path: str):
    start_time = time.time()
    cli = ["go", "run", path]
    result = execute(cli)
    end_time = time.time()
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def test_rust(path: str):
    start_time = time.time()
    output_path = path.replace(".rs", "")
    cli = ["rustc", path, "-o", output_path]
    _ = execute(cli)
    cli = [output_path]
    result = execute(cli)
    end_time = time.time()
    cli = ["rm", output_path]
    _ = execute(cli)
    execution_time = end_time - start_time
    execution_time = round(execution_time, 5)
    return result, execution_time


def get_problem_list():
    return [
        folder
        for folder in os.listdir(".")
        if os.path.isdir(folder) and str(folder).startswith("problem")
    ]


def create_input(problem, data: str):
    with open(f"./{problem}/INPUT", "w") as f:
        f.write(data)
        f.close()


def output_assertion(data_type, expected, output: str = ""):
    output = output.strip()
    if data_type == "number":
        return int(output) == int(expected)


if __name__ == "__main__":
    logging.info("Starting test")
    function_mapping = {
        JAVA: test_java,
        PYTHON: test_python,
        CPP: test_cpp,
        GO: test_go,
        RUST: test_rust,
    }

    problems = get_problem_list()

    for problem in problems:
        with open(f"./{problem}/test.json", "r") as f:
            test_data = json.load(f)

        test_cases = test_data[TEST_CASE]
        supported_languages = test_data[LANGUAGE]

        for test_case in test_cases:
            test_name = test_case[NAME]
            test_input = test_case[INPUT]
            test_output = test_case[OUTPUT]
            logging.info(LOGGING_MESSAGE_1.format(problem, test_name))
            # create INPUT file and put value into it
            create_input(problem, test_input)
            for language in supported_languages:
                path_to_execute_file = (
                    f"./{problem}/{DEFAULT_FILE_NAME}{EXTENSION_MAPPING[language]}"
                )
                _func = function_mapping[language]
                result, execution_time = _func(path_to_execute_file)
                assert_result = output_assertion(
                    test_output["type"], test_output["value"], result
                )
                logging.info(
                    LOGGING_MESSAGE_2.format(
                        language, execution_time, RESULT_MAPPING[assert_result]
                    )
                )
                if not assert_result:
                    raise Exception("TEST FAILED")

    logging.info("Clean up...")
    for problem in problems:
        os.remove(f"./{problem}/INPUT")

