# Hello, world!
#
# This is an example function named 'hello'
# which prints 'Hello, world!'.
#
# You can learn more about package authoring with RStudio at:
#
#   http://r-pkgs.had.co.nz/
#
# Some useful keyboard shortcuts for package authoring:
#
#   Install Package:           'Ctrl + Shift + B'
#   Check Package:             'Ctrl + Shift + E'
#   Test Package:              'Ctrl + Shift + T'


#' Add together two numbers.
#'
#' @param strategy The name of the strategy to call
#' @param account An account number
#' @return An allocation and a stock picking strategy
#' @examples
#' doOperation(1)

doOperation <- function(strategy,account) {
  f <- get(strategy)
  return(f(account))
}


