cDelivery = readFile "$wrks/cpl.json"
def jString = new JsonSlurperClassic().parseText(cDelivery)
def bStr = jString.btool
bStr = bStr + " " + jString.target
bat "$bStr"