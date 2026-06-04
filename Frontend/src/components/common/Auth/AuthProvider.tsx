
import { useEffect, useState } from "react";
import axios from "axios";
import { AuthContext } from "./AuthContext";
import { isAuthenticatedAPI } from "../../../helpers/authHelpers";
import { deleteCookie, getCookie } from "../../../helpers/cookieHelper";

interface Props {
    children: React.ReactNode;
}

export default function AuthProvider({ children }: Props) {

    const [authenticated, setAuthenticated] =
        useState(false);

    const [loading, setLoading] =
        useState(true);

    const [user, setUser] =
        useState<any>(null);

    const refreshUser = async () => {
        try {
            var auth = getCookie("authorized")
            setAuthenticated(!!auth);

            if (!!auth) {
                var res = await isAuthenticatedAPI()
                if (res.success)
                    setUser(res.data)
            }

        } catch {
            setAuthenticated(false);
            setUser(null);
        }
    };

    useEffect(() => {
        refreshUser()
            .finally(() => setLoading(false));

        const handler = () => {

            setAuthenticated(false);
            setUser(null);
        };

        window.addEventListener(
            "auth-expired",
            handler
        );

        return () => {
            window.removeEventListener(
                "auth-expired",
                handler
            );
        };
    }, []);

    return (
        <AuthContext.Provider
            value={{
                authenticated,
                loading,
                user,
                setAuthenticated,
                setUser,
                refreshUser,
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}