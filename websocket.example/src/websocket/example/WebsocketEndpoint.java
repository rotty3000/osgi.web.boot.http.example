/**
 * Copyright 2016 Raymond Augé
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package websocket.example;

import java.util.Date;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import custom.reqcap.annotations.GogoShell;

@Component(
	property = {
		"org.osgi.http.websocket.endpoint.path=/servertime"
	},
	scope = ServiceScope.PROTOTYPE,
	service = Endpoint.class
)
@GogoShell
public class WebsocketEndpoint extends Endpoint {

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		Async remote = session.getAsyncRemote();

		session.addMessageHandler(
			new MessageHandler.Whole<String>() {

				@Override
				public void onMessage(String text) {
					if ("start".equals(text)) {
						process = true;
						_processor = new Thread(new Runnable() {

							@Override
							public void run() {
								while (process) {
									remote.sendText("Server Time: " + new Date());

									try {
										Thread.sleep(1000);
									} catch (InterruptedException ie) {
										Thread.currentThread().interrupt();
										break;
									}
								}
							}
						});

						_processor.start();
					}
					else {
						process = false;
					}
				}

			}
		);
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		Async remote = session.getAsyncRemote();

		remote.sendText("Closing!");

		process = false;
	}

	private boolean process = false;
	private Thread _processor;

}