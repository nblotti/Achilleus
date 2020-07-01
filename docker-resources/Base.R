source_github <- function(strategyname) {
  url <- paste('https://raw.githubusercontent.com/nblotti/R/master/strategy/', strategyname, '.R')
  devtools::source_url(url)

}

