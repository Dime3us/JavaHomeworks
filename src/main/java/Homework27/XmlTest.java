package Homework27;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class XmlTest {
    public static void main(String[] args) throws JAXBException {
        Emp emp = new Emp("Max", 35, "Meneger");
        String fileName = "src/main/java/Homework27/jaxbtest.xml";

        JAXBContext jaxbContext = JAXBContext.newInstance(Emp.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(emp, new File(fileName));
    }
}
