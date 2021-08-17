package assignment2_server_14068171.server;
/*
https://spring.io/guides/gs/testing-web/
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 */


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTests {


    @LocalServerPort
    private int port; // to avoid port conflict with running server, test uses random port = 61???

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void test() {
    }


    @Before
    public void ttt() {
        System.out.println("port = " + port); // port = 61492
        String response = this.testRestTemplate.getForObject("http://localhost:" + port + "/ttt", String.class);
//        System.out.println("response = " + response);
        // assertThat(response).contains("Hello World");

    }


    @Test
    public void istart() {
        String response = this.testRestTemplate.postForObject("http://localhost:" + port + "/ttt/istart", "requestString", String.class);
        System.out.println("response = " + response);
        assertThat(response).contains("istart done");

    }

    @Test
    public void ustart() {
        String response = this.testRestTemplate.postForObject("http://localhost:" + port + "/ttt/ustart", "requestString", String.class);
        System.out.println("response = " + response);
        assertThat(response).contains("ustart done");
    }

/*

    @Test
    public void move() {
        String response = this.testRestTemplate.postForObject("http://localhost:" + port + "/ttt/move/x1z1", "requestString", String.class);
        System.out.println("response = " + response);
        assertThat(response).contains("move done");
    }

    @Test
    public void move400() {
        String response = this.testRestTemplate.postForObject("http://localhost:" + port + "/ttt/move/abcd", "requestString", String.class);
        System.out.println("response = " + response);
        assertThat(response).contains("400 Bad Request");
    }

    @Test
    public void move404() {
        String response = this.testRestTemplate.postForObject("http://localhost:" + port + "/ttt/move/x9z9", "requestString", String.class);
        System.out.println("response = " + response);
        assertThat(response).contains("404 Not Found");
    }


    @Test
    public void state() {
        String response = this.testRestTemplate.getForObject("http://localhost:" + port + "/ttt/state", String.class);
        System.out.println("body = " + response);
        assertThat(response).contains("_");
    }

    @Test
    public void won() {
        String response = this.testRestTemplate.getForObject("http://localhost:" + port + "/ttt/won", String.class);
        System.out.println("body = " + response);
        assertThat(response).isEqualTo("computer");
    }

    @Test
    public void possiblemoves() {
        String response = this.testRestTemplate.getForObject("http://localhost:" + port + "/ttt/possiblemoves", String.class);
        System.out.println("body = " + response);
        assertThat(response).contains("1,1");
    }
*/

}
