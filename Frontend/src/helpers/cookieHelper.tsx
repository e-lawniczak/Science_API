export function setCookie(
    name: string,
    value: string,
    days?: number
): void {
    let expires = "";

    if (days !== undefined) {
        const date = new Date();
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        expires = `; expires=${date.toUTCString()}`;
    }

    document.cookie =
        `${encodeURIComponent(name)}=${encodeURIComponent(value)}${expires}; path=/`;
}

export function getCookie(name: string): string | null {
    const target = `${encodeURIComponent(name)}=`;

    const cookies = document.cookie.split(";");

    for (const cookie of cookies) {
        const trimmed = cookie.trim();

        if (trimmed.startsWith(target)) {
            return decodeURIComponent(
                trimmed.substring(target.length)
            );
        }
    }

    return null;
}

export function deleteCookie(name: string): void {
    document.cookie =
        `${encodeURIComponent(name)}=; expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/`;
}