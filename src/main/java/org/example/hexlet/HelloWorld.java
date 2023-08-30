package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
//        app.get("/users", ctx -> ctx.result("GET /users"));
//        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name);
        });
        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            ctx.result("Course id is: " + id);
        });

        app.get("/users/{user-id}/posts/{post-id}", ctx -> {
            var userId = ctx.pathParam("user-id");
            var postId = ctx.pathParam("post-id");
            ctx.result("User ID: " + userId + " post id: " + postId);
        });
        app.start(7070); // Стартуем веб-сервер
    }
}