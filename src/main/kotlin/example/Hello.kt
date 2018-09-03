package example

import com.redfin.sitemapgenerator.WebSitemapGenerator
import java.io.File
import com.redfin.sitemapgenerator.ChangeFreq
import com.redfin.sitemapgenerator.WebSitemapUrl
import java.util.*

fun main(args: Array<String>) {
    val targetDir = File("./generated").also { it.mkdirs() }
    val wsg = WebSitemapGenerator.builder("http://www.example.com", targetDir)
            .autoValidate(true)
            .build()
    wsg.addUrl("http://www.example.com/index.html")
    wsg.addUrl("http://www.example.com/page1.html")
    wsg.addUrl(WebSitemapUrl.Options("http://www.example.com/news.html")
            .lastMod(Date())
            .priority(1.0)
            .changeFreq(ChangeFreq.HOURLY)
            .build())
    wsg.write()
}
