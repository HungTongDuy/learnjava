package com.example.demo.LearnController;

import com.example.demo.Validator.BookCodeVerify;

import java.util.Objects;

public class BookRequest {

    private String title;

    @BookCodeVerify
    private String code;

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return title.equals(that.title) &&
                code.equals(that.code) &&
                author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, author);
    }

    @Override
    public String toString() {
        return "BookRequest{ title=" + getTitle() + ", code=" + getCode() + ", author=" + getAuthor() + "}";
    }
}
