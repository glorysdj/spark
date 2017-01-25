/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.examples

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
 * Simple test to distribute and return a one-item list from a Spark executor.
 *
 * Mainly used to measure executor startup time in dynamic allocation cluster managers like YARN
 * and Kubernetes.
 */
object ExecutorStartupTest {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      .appName("ExecutorStartupTest")
      .getOrCreate()

    val rdd: RDD[Long] = spark.sparkContext.parallelize(Array[Long](1L))
    if(rdd.count() != 1L) {
      throw new RuntimeException("Count not expected value of 1")
    }
  }
}