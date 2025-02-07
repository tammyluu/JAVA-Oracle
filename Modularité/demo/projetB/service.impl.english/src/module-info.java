module service.impl.english {
    requires service.api;
    provides com.service.api.GreetingService with com.service.impl.english.EnglishGreetingService;
}