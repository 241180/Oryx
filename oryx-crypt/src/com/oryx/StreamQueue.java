/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.oryx;

import com.oryx.interfaces.Stream;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A thread-safe queue for Streams and their derived classes.
 *
 * @param <T>
 * @author steveweis@gmail.com (Steve Weis)
 */
class StreamQueue<T extends Stream> extends ConcurrentLinkedQueue<T> {
    private static final long serialVersionUID = 4914617278167817144L;
}
