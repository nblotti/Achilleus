source_github <- function(strategyname, account) {
  url <- paste('https://raw.githubusercontent.com/nblotti/@project.artifactId@/@project.artifactId@-@project.version@/strategy/', strategyname, '.R', sep = "")
  devtools::source_url(url)

  return(doOperation(account));

}

