use std::env;

fn sub(a: i32, b: i32) -> i32 {
    a - b
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let a: i32 = args[1].parse().unwrap();
    let b: i32 = args[2].parse().unwrap();
    println!("{}", sub(a, b));
}