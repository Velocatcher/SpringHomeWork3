package com.example.seminar3HomeTask.services;

import com.example.seminar3HomeTask.domain.User;
import com.example.seminar3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Поле сервиса работы с хранилищем пользователей
     */
    private DataProcessingService dataProcessingService;

    /**
     * Поле сервиса создания пользователей
     */
    private  UserService userService;

    /**
     * Поле сервиса уведомлений
     */
    private NotificationService notificationService;

    /**
     * Конструктор класса
     * @param dataProcessingService сервис работы с хранилищем пользователей
     * @param userService сервис создания пользователей
     * @param notificationService сервис уведомлений
     */
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Сохранение пользователя
     * @param name
     * @param age
     * @param email
     */
    public void processRegistration(String name, int age, String email) {
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
        notificationService.notifyUser(createUser);
    }

    //    поля UserService, DataProcessingService, NotificationService
//    метод processRegistration
//    getter для DataProcessingService
}
