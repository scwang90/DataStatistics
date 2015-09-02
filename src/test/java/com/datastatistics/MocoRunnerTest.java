package com.datastatistics;

import com.github.dreamhead.moco.*;
import com.github.dreamhead.moco.handler.proxy.ProxyConfig;
import com.github.dreamhead.moco.internal.SessionContext;
import org.apache.http.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.*;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.runner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MocoRunnerTest {
    private Runner runner;

    @Before
    public void setup() {
        HttpServer server = httpServer(12308);
        server.request(match(uri("/\\d*/foo"))).response(seq("foo", "bar", "blah"));
        server.request(match(uri("/helo"))).response(with("rewrew"),header("name", "scwang"),status(404));
        runner = runner(server);
        runner.start();
//        helper = new MocoTestHelper();
    }

    @After
    public void tearDown() {
        runner.stop();
    }

    @Test
    public void should_response_as_expected() throws IOException {
        Content content = Request.Get("http://localhost:12308/120003/foo").execute().returnContent();
        System.out.println(content);content = Request.Get("http://localhost:12308/120003/foo").execute().returnContent();
        System.out.println(content);content = Request.Get("http://localhost:12308/120003/foo").execute().returnContent();
        System.out.println(content);
        Response response = Request.Get("http://localhost:12308/helo").execute();
        HttpResponse httpResponse = response.returnResponse();
        System.out.println("l:"+httpResponse.getStatusLine().getStatusCode());
        for (Header header : httpResponse.getAllHeaders()){
            System.out.println("h:"+header.getName()+"->"+header.getValue());
        }
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
//        assertEquals(content.asString(), "foo");
//        assertThat(content.asString(), is("foo"));
    }
}