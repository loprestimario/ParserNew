package outWriter.implementation

import outWriter.OutWriter
import process.Summary

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 22/07/13
 * Time: 22.49
 * To change this template use File | Settings | File Templates.
 */

class WriteSummary extends OutWriter {


    public void write(Summary summary,String pathFile) {
        HashMap nationsMap = summary.getNationsMap()
        def countClaims = summary.getCountClaims()
        def countTei = summary.getCountTei()
        def idFamily = summary.getIdFamily()
        def nationPlus = summary.getNationPlus()
        def count = summary.getCount()
        def fw = new FileWriter(pathFile)
        def xml = new groovy.xml.MarkupBuilder(fw)

        xml.summary() {
            idfamily(idFamily)
            numberPatent(1)
            xml.Nations() {
                for (nation in nationsMap.keySet()) {
                    nat(nation)
                }
            }
            biggestPatentNation(nationPlus)
            numberApplication(countTei)
            numberPublication(count)
        }
    }


}
