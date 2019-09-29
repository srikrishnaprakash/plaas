cDelivery = readFile "$wrks/cpl.json"
def jString = new JsonSlurperClassic().parseText(cDelivery)
def bStr = jString.btool
bStr = bStr + " -f app/pom.xml " + jString.target
bat "$bStr"