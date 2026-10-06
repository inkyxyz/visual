package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Method;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import lombok.Generated;

public class iiIiiIi_Class110 extends NanoHTTPD implements iIIiIIiIi_Class294 {
   private final File I_field_3a58077 = new File(I_field_3a9bda27.runDirectory, "Rockstar" + File.separator + "configs");
   private String I_field_523beb0a;
   private boolean I_field_5a;

   public iiIiiIi_Class110() throws IOException {
      super(5656);
      if (!this.I_field_3a58077.exists() && !this.I_field_3a58077.mkdirs()) {
         throw new IOException(
            "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u0430\u043f\u043a\u0443 \u0434\u043b\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u043e\u0432: "
               + this.I_field_3a58077
         );
      } else {
         this.start(5000, false);
         System.out
            .println(
               "\u0421\u0435\u0440\u0432\u0435\u0440 \u0437\u0430\u043f\u0443\u0449\u0435\u043d \u043d\u0430 \u043f\u043e\u0440\u0442\u0443 5656, \u043a\u043e\u043d\u0444\u0438\u0433\u0438 \u0432 "
                  + this.I_field_3a58077.getAbsolutePath()
            );
      }
   }

   public Response serve(IHTTPSession var1) {
      if (Method.POST.equals(var1.getMethod())) {
         try {
            HashMap var2 = new HashMap();
            var1.parseBody(var2);
            String var3 = (String)var2.get("file");
            if (var3 != null) {
               String var4 = String.valueOf(var1.getParameters().get("file"));
               if (var4 == null || var4.isEmpty()) {
                  var4 = "client.rock";
               }

               this.I_field_523beb0a = var4;
               this.I_field_5a = true;
               String var5 = var4.endsWith(".rock") ? var4 : var4 + ".rock";
               String var6 = var5.substring(0, var5.lastIndexOf(46));
               JsonElement var7 = JsonParser.parseString(Files.readString(Path.of(var3)));
               if (!var7.isJsonObject()) {
                  return newFixedLengthResponse(
                     Status.BAD_REQUEST,
                     "text/plain",
                     "\u0424\u0430\u0439\u043b \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u043e\u043c"
                  );
               }

               RockstarClient.getInstance().I_method_5198232b().I_method_a9011662(var6, var7.getAsJsonObject());
               return newFixedLengthResponse(
                  "\u041a\u043e\u043d\u0444\u0438\u0433 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d \u0432 \u043a\u043b\u0438\u0435\u043d\u0442"
               );
            }
         } catch (Exception var8) {
            return newFixedLengthResponse("\u041e\u0448\u0438\u0431\u043a\u0430 \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438: " + var8.getMessage());
         }
      }

      this.I_field_5a = false;
      String var9 = "<!DOCTYPE html> <html lang=\"ru\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u043a\u043e\u043d\u0444\u0438\u0433\u0430</title>\n  <style>\n    body {\n      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;\n      display: flex;\n      flex-direction: column;\n      align-items: center;\n      justify-content: center;\n      height: 100vh;\n      margin: 0;\n      padding: 20px;\n      background: #f2f2f2;\n    }\n\n    h1 {\n      font-size: 1.8em;\n      margin-bottom: 1em;\n      text-align: center;\n    }\n\n    form {\n      display: flex;\n      flex-direction: column;\n      gap: 15px;\n      width: 100%;\n      max-width: 400px;\n      background: #fff;\n      padding: 20px;\n      border-radius: 12px;\n      box-shadow: 0 4px 10px rgba(0,0,0,0.1);\n    }\n\n    input[type=\"file\"] {\n      font-size: 1.1em;\n    }\n\n    input[type=\"submit\"] {\n      padding: 12px;\n      font-size: 1.2em;\n      border: none;\n      border-radius: 8px;\n      background: #007aff;\n      color: white;\n      cursor: pointer;\n      transition: background 0.3s ease;\n    }\n\n    input[type=\"submit\"]:hover {\n      background: #005fcc;\n    }\n\n    @media (max-width: 400px) {\n      h1 {\n        font-size: 1.4em;\n      }\n      input[type=\"submit\"] {\n        font-size: 1em;\n        padding: 10px;\n      }\n    }\n  </style>\n</head>\n<body>\n  <h1>\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433 Rockstar</h1>\n  <form method=\"POST\" enctype=\"multipart/form-data\">\n    <input type=\"file\" name=\"file\" accept=\".rock\" required />\n    <input type=\"submit\" value=\"\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0432 \u043a\u043b\u0438\u0435\u043d\u0442\" />\n  </form>\n</body> </html>";
      return newFixedLengthResponse(Status.OK, "text/html", var9);
   }

   @Generated
   public String I_method_d121ea01() {
      return this.I_field_523beb0a;
   }

   @Generated
   public boolean I_method_77ae3883() {
      return this.I_field_5a;
   }
}
