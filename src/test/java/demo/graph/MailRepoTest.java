package demo.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailRepoTest {
    @Autowired
    private MailRepo mailRepo;

    @Test
    public void case1() throws Exception {
        Mail mail = new Mail("Hello");
        mail.setBody("Thanks");
        mail.addAttachment(new Attachment("file1", new byte[]{0, 1, 2}));
        mail.addAttachment(new Attachment("file2", new byte[]{0, 1, 2}));
        mailRepo.saveAndFlush(mail);
        Mail mail1 = mailRepo.findOne(mail.getId());
        assertEquals(mail.getSubject(), mail1.getSubject());
        assertEquals(mail.getBody(), mail1.getBody());
//        assertEquals(0, mail1.getAttachments().size()); // fetch lazily
    }

    @Test
    public void case2() throws Exception {
        Mail mail = new Mail("Hello");
        mail.setBody("Thanks");
        mail.addAttachment(new Attachment("file1", new byte[]{0, 1, 2}));
        mail.addAttachment(new Attachment("file2", new byte[]{0, 1, 2}));
        mailRepo.saveAndFlush(mail);
        Mail mail1 = mailRepo.findById(mail.getId());
        assertEquals(mail.getSubject(), mail1.getSubject());
        assertEquals(mail.getBody(), mail1.getBody());
        assertEquals(mail.getAttachments().size(), mail1.getAttachments().size());
    }

    @Test
    public void case3() throws Exception {
        Mail mail = new Mail("Hello");
        mail.setBody("Thanks");
        mail.addAttachment(new Attachment("file1", new byte[]{0, 1, 2}));
        mail.addAttachment(new Attachment("file2", new byte[]{0, 1, 2}));
        mailRepo.saveAndFlush(mail);
        MailSubject mail1 = mailRepo.findMailById(mail.getId());
        assertEquals(mail.getId(), mail1.getId());
        assertEquals(mail.getSubject(), mail1.getSubject());
    }
}