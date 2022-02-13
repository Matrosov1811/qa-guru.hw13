package pav.matrosov.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WildberriesTests extends TestBase {

    @Test
    @Description("Проверка открытия главной страницы")
    @DisplayName("Проверка открытия главной страницы")
    void openMainPageTest() {
            step("Открывается главная страница Wildberries", () -> {
                open("https://www.wildberries.ru/");
            });

            step("Проверка отображения элемента", () -> {
                $(".nav-element__logo").shouldBe(visible);
            });
        }

    @Test
    @Description("Проверка поиска")
    @DisplayName("Проверка поиска")
    void searchTest() {
        step("Открывается главная страница Wildberries", () -> {
            open("https://www.wildberries.ru/");
        });

        step("Вводим поисковый запрос", () -> {
            $("#searchInput").setValue("майка").pressEnter();
        });

        step("Проверка поисковой выборки", () -> {
            $(".searching-results__title").shouldHave(text("По запросу «майка» найдено"));
        });
    }

    @Test
    @Description("Проверка кнопки выпадающего меню")
    @DisplayName("Проверка кнопки выпадающего меню")
    void burgerButtonTest() {
        step("Открывается главная страница Wildberries", () -> {
            open("https://www.wildberries.ru/");
        });

        step("Нажимается кнопка выпадающего меню", () -> {
            $(".nav-element__burger").click();
        });

        step("Проверка отображения выпадающего меню", () -> {
            $(".menu-burger__main").shouldBe(visible);
        });
    }

    @Test
    @Description("Проверка перехода на страницу товара")
    @DisplayName("Проверка перехода на страницу товара")
    void pageItemTest() {
        step("Открывается главная страница Wildberries", () -> {
            open("https://www.wildberries.ru/");
        });

        step("Вводим поисковый запрос", () -> {
            $("#searchInput").setValue("майка").pressEnter();
        });

        step("Переходим на страницу товара", () -> {
            $(".brand-name").shouldHave(text("GREY CARDINAL ")).click();
        });

        step("Проверка отображения страницы товара", () -> {
            $(".same-part-kt__header").shouldBe(visible);
        });
    }
    @Test
    @Description("Проверка добавления товара в корзину")
    @DisplayName("Проверка добавления товара в корзину")
    void addItemTest() {
        step("Открывается главная страница Wildberries", () -> {
            open("https://www.wildberries.ru/");
        });

        step("Вводим поисковый запрос", () -> {
            $("#searchInput").setValue("майка").pressEnter();
        });

        step("Переходим на страницу товара", () -> {
            $(".brand-name").shouldHave(text("GREY CARDINAL ")).click();
        });

        step("Добавляем товар в корзину", () -> {
            $(".same-part-kt__header").shouldBe(visible);
            $(".sizes-list__item").click();
            $(".btn-main").click();
            $(".btn-base").click();
            $(".good-info__good-brand").shouldBe(visible);
        });
    }
}
