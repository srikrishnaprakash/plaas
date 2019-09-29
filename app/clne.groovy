println("Clonning the application...")
dir('appl') {
    git(
        url: "$AppRepo",
        branch: "$Branch"
    )
}
println("Completed")