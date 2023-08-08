<?php
// Your code here!
/* 
Burgerking sells three items:
VegBurger which needs 2 breads & 1 veg pattice
NonVegBurger which needs 2 breads & 1 non-veg pattice
TikkiBurger which needs 2 breads & 1 tikki pattice


Given bread quantity, veg pattice quantity, non-veg pattice quantity, tikki pattice quantity & price of all 3 items

Print the total maximum possible profit by making all possible items based on bread availability 

Also, test for all inputs, we would change all the values while testing, the quantity values as well as price

And program has to be optimal with respect to time & space complexity
*/
$breads = 15;
$vegPattice = 3;
$nonVegPattice = 2;
$tikkiPattice = 1;
$priceVegBurger = 100;
$priceNonVegBurger = 125;
$priceTikkiBurger = 112;

$maxProfit = 0;

while ($breads >= 2 && ($vegPattice >= 1 || $nonVegPattice >= 1 || $tikkiPattice >= 1)) {
    $maxPrice = max($priceVegBurger, $priceNonVegBurger, $priceTikkiBurger);

    if ($maxPrice == $priceVegBurger && $vegPattice >= 1) {
        $maxProfit += $priceVegBurger;
        $vegPattice--;
    } elseif ($maxPrice == $priceNonVegBurger && $nonVegPattice >= 1) {
        $maxProfit += $priceNonVegBurger;
        $nonVegPattice--;
    } elseif ($maxPrice == $priceTikkiBurger && $tikkiPattice >= 1) {
        $maxProfit += $priceTikkiBurger;
        $tikkiPattice--;
    }

    $breads -= 2;
}

echo "Maximum Profit: " . $maxProfit . "\n";


?>
