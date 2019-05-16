# Retrofit + Kotlin + Android jetpack


InSide Sample :

**1. Get data from API by using retrofit**


**2. Parse data from retrofit**

**3. Showing all data in androidx jetpack**

**4. All code in KOTLIN**

## API :  https://reqres.in/api/users?page=1

<p align="center">
  <img width="460" height="300" src="https://github.com/datanapps/RetrofitKotlin/blob/master/screens/screen_1.png">
</p>

![alt text](https://github.com/datanapps/RetrofitKotlin/blob/master/screens/screen_1.png)


### 1. All dependencies :

        dependencies {
            implementation fileTree(dir: 'libs', include: ['*.jar'])
            implementation 'androidx.appcompat:appcompat:1.1.0-alpha05'

          // app compact
          implementation "androidx.appcompat:appcompat:1.1.0-alpha05"

          // constraint layout
          implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

          // recycle view
          implementation 'androidx.recyclerview:recyclerview:1.1.0-alpha05'

          // glide
          implementation 'com.github.bumptech.glide:glide:4.9.0'
          annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'

          // retrofit
          implementation 'com.squareup.retrofit2:retrofit:2.5.0'
          implementation 'com.squareup.okhttp3:logging-interceptor:3.11.0'
          // gson convertor
          implementation 'com.squareup.retrofit2:converter-gson:2.5.0'

          testImplementation 'junit:junit:4.12'
          androidTestImplementation 'androidx.test:runner:1.2.0-beta01'
          androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0-beta01'
          implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
          }
          
          
### 2. Retrofit Network Client:

 object NetworkClient{


    private val BASE_URL = " https://reqres.in"
    private val TIMEOUT = 10
    var retrofit: Retrofit? = null
    /*
    This public static method will return Retrofit client
    anywhere in the appplication
    */
    val retrofitClient: Retrofit
        get() {
            if (retrofit == null) {
                val okHttpClientBuilder = OkHttpClient.Builder()
                okHttpClientBuilder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClientBuilder.build())
                        .build()
            }
            return retrofit!!
        }

     }

### 3. API End User

        /**
         * API for getting weather from https://darksky.net/
         */
        interface APIUser {

            @GET("api/users?")
            fun getUserList(@QueryMap options: Map<String, String>): Call<BaseUser>
        }
        
### 4. Now Hit API 


    val retrofit = NetworkClient.retrofitClient
            mApiUser = retrofit.create<APIUser>(APIUser::class.java)

        val data = HashMap<String, String>()
        data["page"] = "1"

        val apiUserCall = mApiUser!!.getUserList(data)
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */

        apiUserCall.enqueue(object : Callback<BaseUser> {

            override fun onResponse(call: Call<BaseUser>?, response: Response<BaseUser>?) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response?.body() != null) {
                    retrofitEventListener.onSuccess(call, response?.body())
                }
            }
            override fun onFailure(call: Call<BaseUser>?, t: Throwable?) {
                /*
                Error callback
                */
                retrofitEventListener.onError(call, t)
            }
        })


