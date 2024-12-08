package github.macices.kotlin.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/greeting")
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @GetMapping("/{name}")
    fun greeting(@PathVariable name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name!")
    }


}