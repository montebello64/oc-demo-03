# oc-demo-03

oc new-project oc-demo-03
oc project oc-demo-03

oc new-app \  
https://github.com/montebello64/oc-demo-03.git \  
--docker-image=montebello64/java-s2i \  
--context-dir=rest-name \  
--name=rest-name \  
-e SPRING_PROFILES_ACTIVE=openshift \  
-l microservice=oc-demo-03

oc expose service rest-name \  
--hostname=rest-name.zuggerschnecksche.de

oc new-app \  
https://github.com/montebello64/oc-demo-03.git \  
--docker-image=montebello64/java-s2i \  
--context-dir=rest-greeting \  
--name=rest-greeting \  
-e SPRING_PROFILES_ACTIVE=openshift \  
-l microservice=oc-demo-03

oc expose service rest-greeting \  
--hostname=rest-greeting.zuggerschnecksche.de

oc new-app \  
https://github.com/montebello64/oc-demo-03.git \  
--docker-image=montebello64/java-s2i \  
--context-dir=rest-consumer-gui \  
--name=rest-consumer-gui \  
-e SPRING_PROFILES_ACTIVE=openshift \  
-l microservice=oc-demo-03

oc expose service rest-consumer-gui \  
--hostname=rest-consumer-gui.zuggerschnecksche.de
