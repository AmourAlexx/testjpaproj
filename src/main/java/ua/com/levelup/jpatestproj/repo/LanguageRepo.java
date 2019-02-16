package ua.com.levelup.jpatestproj.repo;

import org.springframework.data.repository.CrudRepository;
import ua.com.levelup.jpatestproj.model.Language;

/**
 * Все спринг-репозитори - это дженерики с двойным типом. Первый - тип Entity, второй - тип ID
 * Репозитори - спрингловая замена (аналог) DAO
 */
public interface LanguageRepo extends CrudRepository<Language,Long> {
//хоть интерфейс и пустой, здесь уже есть ряд базовых методов из CrudRepository
}
