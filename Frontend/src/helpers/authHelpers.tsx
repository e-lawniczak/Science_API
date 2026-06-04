import { APIClient } from "./APIClient";
import { API_ROUTES } from "../components/common/API_ROUTES";

export async function isAuthenticatedAPI() {
    var api = new APIClient()
    var res = await api.get(API_ROUTES.me);
    
    return res;
}

export const logout = async () => {
    var api = new APIClient()
    var res = await api.get(API_ROUTES.logout);
    return res;
}

export const login = async (data:any) => {
    var api = new APIClient()
    var res = await api.post(API_ROUTES.login, data);
    return res;
    
}

export const registerUser = async (data:any) => {
    var api = new APIClient()
    var res = await api.post(API_ROUTES.register, data);
    return res;
}



