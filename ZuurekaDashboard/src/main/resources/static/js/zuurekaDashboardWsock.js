var service = {};
var socket = {
  client: null,
  stomp: null
};

service.SOCKET_URL = "/gs-guide-websocket";
service.TOPIC = "/topic/eurekaAppChangeEvent";

function startListener() {
  socket.stomp.subscribe(service.TOPIC, function (data) {
	  angular.element($('#zuurekaDashboard')).scope().messageFromWS(angular.fromJson(data.body));
  });
};

function initializeWebSocket() {
  socket.client = new SockJS(service.SOCKET_URL);
  socket.stomp = Stomp.over(socket.client);
  socket.stomp.connect({}, startListener);
  socket.stomp.debug = null;
};
