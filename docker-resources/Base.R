source_github <- function(strategyname) {
  url <- paste('https://github.com/nblotti/R/strategy/', strategyname, '.R?raw=TRUE')
  devtools::source_url(url)

}

