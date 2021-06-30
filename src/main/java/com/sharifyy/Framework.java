package com.sharifyy;

import java.util.List;
import java.util.Objects;

public class Framework {
    private final String title;
    private final List<String> languages;

    public Framework(String title, List<String> languages) {
        this.title = title;
        this.languages = languages;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Framework framework = (Framework) o;

        return Objects.equals(title, framework.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Framework{" +
                "title='" + title + '\'' +
                '}';
    }
}
