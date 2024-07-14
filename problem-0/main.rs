use std::env;

fn sum(a: i32, b: i32) -> i32 {
    a + b
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let a: i32 = args[1].parse().unwrap();
    let b: i32 = args[2].parse().unwrap();
    println!("{}", sum(a, b));
}