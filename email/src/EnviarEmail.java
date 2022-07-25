package src;

import javax.activation.DataSource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
    public static void main(String[] args) throws Exception {
        String meuEmail = "caneppele1.6@gmail.com";
        String senha = "588790132";
        EmailAttachment anexo = new EmailAttachment();
        anexo.setPath("/home/flexabus-java-3/TEST");
        anexo.setName("javaas");
        anexo.setDescription("codigos javas compactados");
        MultiPartEmail email = new MultiPartEmail();
        //try {
            email.setHostName("smtp.office365.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
            //email.setSSLOnConnect(true);
            email.setStartTLSEnabled(true);
            email.setFrom(meuEmail);
            email.setSubject("teste2");
            email.setMsg("teste de enviar email2");
            email.addTo("joao.caneppele@universo.univates.br");
            email.attach(anexo);
            email.send();
            System.out.println("ENVIADO");
        //} catch (Exception e) {
        //    System.out.println(e + ": ErRor");
        //}

    }
}
