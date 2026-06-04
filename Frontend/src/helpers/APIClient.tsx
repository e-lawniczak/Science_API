import axios, { AxiosError } from "axios";
import { api_url } from "../components/common/ProjectPages";
import type { APIResponse, RawAPIResponse } from "./models";
import { deleteCookie } from "./cookieHelper";

export class APIClient {
    API_URL: any;

    constructor() {
        this.API_URL = api_url
    }

    get = async (requestUrl: string, options?: any) => {
        try {
            const res: RawAPIResponse = await axios.get(
                `${this.API_URL}${requestUrl}`,
                {
                    withCredentials: true,
                    ...options
                }
            );

            return this.#parseResponse(res);

        } catch (error) {

            if (axios.isAxiosError(error) && error.response) {
                var errRes = this.#parseResponse((error.response as RawAPIResponse));
                if (errRes.httpStatus == 401)
                    this.#handleUnauthorizedRequest()
                return errRes;
            }

            throw error;
        }
    }

    post = async (requestUrl: string, body: any, options?: any) => {
        try {
            const res: RawAPIResponse = await axios.post(
                `${this.API_URL}${requestUrl}`,
                body,
                {
                    withCredentials: true,
                    ...options
                }
            );

            return this.#parseResponse(res);

        } catch (error) {

            if (axios.isAxiosError(error) && error.response) {
                var errRes = this.#parseResponse((error.response as RawAPIResponse));
                if (errRes.httpStatus == 401)
                    this.#handleUnauthorizedRequest()
                return errRes;
            }

            throw error;
        }
    }

    #parseResponse = (response?: RawAPIResponse): APIResponse => {

        if (!response)
            return {
                data: null,
                message: "Wystąpił błąd przy przetwarzaniu odpowiedzi API",
                status: -1,
                httpStatus: 500,
                success: false
            }

        return {
            ...response.data,
            httpStatus: response.status,
            success: response.data.status == 1
        }
    }

    #handleUnauthorizedRequest = () => {
        console.log("dispatching auth-expired");
        deleteCookie("authorized")
        window.dispatchEvent(
            new CustomEvent("auth-expired")
        );
    }

}