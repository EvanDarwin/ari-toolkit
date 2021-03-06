package com.ausregistry.jtoolkit2.se.unspec;

import com.ausregistry.jtoolkit2.se.Command;
import com.ausregistry.jtoolkit2.se.CommandExtension;
import com.ausregistry.jtoolkit2.se.ExtendedObjectType;
import com.ausregistry.jtoolkit2.xml.XMLWriter;
import org.w3c.dom.Element;


/**
 * <p>Extension for the EPP Domain Update command, representing the Update  Domain aspect of the
 * Domain Name Unspec Extension.</p>
 *
 * <p>Use this to identify the unspec associated with this domain name as part of an EPP Domain Update
 * command compliant with RFC5730 and RFC5731. The "extContact" value
 * will be supplied.
 * The response expected from a server should be handled by a Domain Update Response.</p>
 *
 * @see com.ausregistry.jtoolkit2.se.DomainUpdateCommand
 * @see com.ausregistry.jtoolkit2.se.Response
 */
public class DomainUpdateCommandUnspecExtension implements CommandExtension {

    private static final long serialVersionUID = 5982521830455586062L;

    private final String extContactId;

    public DomainUpdateCommandUnspecExtension(String extContactId) {
        this.extContactId = extContactId;
    }

    @Override
    public void addToCommand(Command command) {
        final XMLWriter xmlWriter = command.getXmlWriter();
        final Element extensionElement = command.getExtensionElement();

        final Element unspecElement = xmlWriter.appendChild(extensionElement, "extension",
                ExtendedObjectType.UNSPEC.getURI());

        xmlWriter.appendChild(unspecElement, "unspec", ExtendedObjectType.UNSPEC.getURI())
                .setTextContent("extContact=" + extContactId);

    }

}
