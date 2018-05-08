package xyz.laziness.dailycommit.data.network.github

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import okhttp3.Credentials
import okhttp3.OkHttpClient
import xyz.laziness.dailycommit.data.network.github.request.LoginRequest
import xyz.laziness.dailycommit.data.network.github.response.LoginResponse
import javax.inject.Inject


class GitHubApiHelper @Inject constructor() : GitHubApi {

    override fun doServerBasicLoginApiCall(userName: String, password: String): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(GitHubApiConstants.REST_LOGIN_URL)
                    .addApplicationJsonBody(LoginRequest.BasicLoginRequest())
                    .setOkHttpClient(OkHttpClient.Builder()
                            .addInterceptor(GitHubInterceptor(Credentials.basic(userName, password)))
                            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build())
                    .build()
                    .getObjectObservable(LoginResponse::class.java)
}