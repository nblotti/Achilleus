source_github <- function(strategyname) {
  url <- paste('https://raw.githubusercontent.com/nblotti/@project.artifactId@/@project.version@/strategy/', strategyname, '.R', sep = "")
  devtools::source_url(url)

}

