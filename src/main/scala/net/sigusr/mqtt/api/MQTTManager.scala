/*
 * Copyright 2014 Frédéric Cabestre
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sigusr.mqtt.api

import java.net.InetSocketAddress

import akka.actor.Props
import akka.io.{IO, Tcp}
import net.sigusr.mqtt.impl.protocol.{Protocol, TCPTransport}

class MQTTManager(remote: InetSocketAddress) extends TCPTransport(remote) with Protocol {
  import context.system
  override def tcpManagerActor = IO(Tcp)
}

object MQTTManager {
  def props(remote: InetSocketAddress) = Props(classOf[MQTTManager], remote)
}

