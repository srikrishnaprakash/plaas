println("Clonning the application...")
dir('app') {
    git(
        url: "$AppRepo",
        branch: "$Branch"
    )
}
println("Completed")