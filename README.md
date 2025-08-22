# pixoo64

This project is a Quarkus-based module that provides a service layer to control a Divoom Pixoo device via its HTTP API.
It is designed to be included as a dependency in other projects.
Its based on the inoffical API documentation available at <https://doc.divoom-gz.com/web/#/12?page_id=219>

## Features

- Initialize and configure a Pixoo device (timezone, UTC time, 24-hour mode, brightness).

- Draw and send graphics to the Pixoo (pixels, rectangles, lines, images).

- Render text in different alignments (left, right, center) using custom fonts.

- Send scrolling or static text via the Pixoo HTTP API.

- Push images or animations (SendHttpGif).

- Manage Pixoo device commands such as reboot or brightness adjustment.

- Utility support for working with fonts, colors, and positions.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Installation

Add the module as a dependency to your Quarkus project:

```
<dependency>
    <groupId>de.paulmannit</groupId>
    <artifactId>pixoo-service</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Configuration

The service requires at least the Pixoo display size and the url to be configured in application.properties:

```
pixoo.size=64
pixoo-api/mp-rest/url=http://192.168.177.115
```
## Usage

```
@Startup
@ApplicationScoped
public class PageService {
    @Inject
    PixooService pixooService;

    @PostConstruct
    public void startup() {
        init();
    }

    public void init() {
        pixooService.initialize();

        TextItem item = new TextItem();
        item.setTextId(2);
        item.setX(1);
        item.setY(10);
        item.setDir(0);
        item.setFont(1);
        item.setTextWidth(64);
        item.setSpeed(10);
        item.setTextString("Hello Pixoo");
        item.setColor("#FF0000");
        item.setAlign(1);

        pixooService.sendHttpText(item);
    }
}
```

