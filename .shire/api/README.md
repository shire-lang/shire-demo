# API Development

## API Testing

- JMETER
- Postman
- K6
- Gatling
- Locust
- Apache Bench (ab)
- Artillery
- Blazemeter
- Swagger/OpenAPI Validator + Load Test
- Taurus

### Gatling

https://docs.gatling.io/tutorials/scripting-intro/

```java
package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class ComputerDatabaseSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol =
    http.baseUrl("https://computer-database.gatling.io")
      .acceptHeader("application/json")
      .contentTypeHeader("application/json");

  ScenarioBuilder myFirstScenario = scenario("My First Scenario")
    .exec(http("Request 1")
      .get("/computers/"));

  {
    setUp(
      myFirstScenario.injectOpen(constantUsersPerSec(2).during(60))
    ).protocols(httpProtocol);
  }
}
```

### ab

https://httpd.apache.org/docs/current/programs/ab.html

```bash
ab -n 500 -c 50 -p data.json -T application/json http://example.com/api/v1/resource
```

### JMeter

https://jmeter.apache.org/

### Locust

https://docs.locust.io/en/stable/

```python
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 2)

    def on_start(self):
        self.client.post("/login", json={"username":"foo", "password":"bar"})

    @task
    def hello_world(self):
        self.client.get("/hello")
        self.client.get("/world")

    @task(3)
    def view_item(self):
        for item_id in range(10):
            self.client.get(f"/item?id={item_id}", name="/item")
```

### K6

https://k6.io/

```javascript
import http from 'k6/http'
import { check, sleep } from 'k6'

export default function () {
  const data = { username: 'username', password: 'password' }
  let res = http.post('https://myapi.com/login/', data)

  check(res, { 'success login': (r) => r.status === 200 })

  sleep(0.3)
}
```

## Record-Replay

- https://github.com/alibaba/jvm-sandbox-repeater
- [iTestin](https://www.testin.cn/business/landing/test_autorec.htm)
- [Katalon Recorder](https://katalon.com/katalon-recorder-ide)

