import { createContext, useContext } from "react";

export interface AuthContextType {
    authenticated: boolean;
    loading: boolean;
    user: any | null;

    setAuthenticated: React.Dispatch<React.SetStateAction<boolean>>;
    setUser: React.Dispatch<React.SetStateAction<any | null>>;

    refreshUser: () => Promise<void>;
}

export const AuthContext =
    createContext<AuthContextType | undefined>(undefined);

export function useAuth(): AuthContextType {
    const context = useContext(AuthContext);

    if (!context) {
        throw new Error(
            "useAuth must be used within AuthProvider"
        );
    }

    return context;
}