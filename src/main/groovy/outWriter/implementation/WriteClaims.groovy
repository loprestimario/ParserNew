package outWriter.implementation

import groovy.xml.XmlUtil
import outWriter.OutWriter

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 22/07/13
 * Time: 22.42
 * To change this template use File | Settings | File Templates.
 */

//'src/main/resources/outputClaims.xml'

public class WriteClaims extends OutWriter {


    public void write(Map claims,String pathFile) {
        def fw = new FileWriter(pathFile)
        def xml = new groovy.xml.MarkupBuilder(fw)
        def count = 0

        xml.priorities() {
            for (name in claims.keySet()) {
                def c = claims.get(name)
                for (int i = 0; i < c.size(); i++) {
                    xml.priority(n: count, type: c.get(i).@subtype, source: name) {
                        mkp.yieldUnescaped XmlUtil.serialize(c.get(i))
                    }
                    count++
                }
            }
        }
    }


}