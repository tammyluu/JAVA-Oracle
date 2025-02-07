module service.impl.french {
    requires service.api;
    provides com.service.api.GreetingService with com.service.impl.french.FrenchGreetingService;
}