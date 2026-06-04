export interface APIData{
    message: string,
    data: any,
    status: number
}

export interface RawAPIResponse{
    config:{
        timeout: number, xsrfCookieName: string, xsrfHeaderName: string
    },
    data: APIData,
    headers: any,
    request: any,
    status: number,
    statusText: string
}

export interface APIResponse{
    data: any,
    message: string,
    status: number,
    httpStatus: number,
    success: boolean,
}