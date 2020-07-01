source_github <- function(strategyname) {
  url <- paste('https://raw.githubusercontent.com/nblotti/R/master/strategy/', strategyname, '.R', sep = "")
  devtools::source_url(url)

}

