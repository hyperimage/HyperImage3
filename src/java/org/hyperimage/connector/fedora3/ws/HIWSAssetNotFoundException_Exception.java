
package org.hyperimage.connector.fedora3.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "HIWSAssetNotFoundException", targetNamespace = "http://fedora3.connector.hyperimage.org/")
public class HIWSAssetNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private HIWSAssetNotFoundException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public HIWSAssetNotFoundException_Exception(String message, HIWSAssetNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public HIWSAssetNotFoundException_Exception(String message, HIWSAssetNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.hyperimage.connector.fedora3.ws.HIWSAssetNotFoundException
     */
    public HIWSAssetNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
