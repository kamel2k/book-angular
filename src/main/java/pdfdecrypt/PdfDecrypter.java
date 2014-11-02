package pdfdecrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PdfDecrypter {

	  public static void main(String[] args) throws Exception {
//		    PdfEncryptor
//		        .encrypt(new PdfReader("1.pdf"), new FileOutputStream("Encrypted2.pdf"),
//		            "Hello".getBytes(), "World".getBytes(), PdfWriter.AllowDegradedPrinting,
//		            PdfWriter.STRENGTH128BITS);

		    // decrypt the file

		  Path path = Paths.get("E:\\work\\key.blob");
		  byte[] data = Files.readAllBytes(path);
		  
		  InputStream is = new FileInputStream("E:\\work\\key.blob");
		  byte [] data2 = IOUtils.toByteArray(is);
		  
		  System.out.println("data2=" + data2);
		  
		  //getEncryptionInformation("E:\\work\\0001.pdf");
		    System.out.println("data=" + data.toString());
		    PdfReader reader = new PdfReader("E:\\work\\0001.pdf", data2);
//		    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("E:\\work\\0002.pdf"));
//		    stamper.close();
//
//		    getEncryptionInformation("Encrypted2.pdf", "World");
//		    getEncryptionInformation("Decrypted1.pdf", "World");
		  }

		  public static void getEncryptionInformation(String filename, String ownerpassword)
		      throws Exception {
		    PdfReader reader;
		    if (ownerpassword == null)
		      reader = new PdfReader(filename);
		    else
		      reader = new PdfReader(filename, ownerpassword.getBytes());
		    System.out.println("Encrypted? " + reader.isEncrypted());
		    if (reader.isEncrypted()) {
		      System.out.println("Permissions: "
		          + PdfEncryptor.getPermissionsVerbose(reader.getPermissions()));
		      System.out.println("128 bit? " + reader.is128Key());
		    }
		  }
}
