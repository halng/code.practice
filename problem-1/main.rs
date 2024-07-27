use std::env;
use std::fs::File;
use std::io::Read;

fn sub(a: i32, b: i32) -> i32 {
    a - b
}

fn main() {
    let mut input = String::new();
    let mut file = File::open("./problem-1/INPUT").expect("Failed to open file");
    file.read_to_string(&mut input).expect("Failed to read file");

    let mut values = input.trim().split_whitespace();
    let a: i32 = values.next().expect("Missing value").parse().expect("Invalid value");
    let b: i32 = values.next().expect("Missing value").parse().expect("Invalid value");
    println!("{}", sub(a, b));
}